#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
// #include <sys/wait.h>
// #include <sys/ipc.h>
// #include <sys/msg.h>
#include <string.h>
#define MAX_WORKERS_PER_DAY 10
#define MAX_WORKERS_IN_BUS 5
#define MAX_LINE_LENGTH 100
#define MAX_NAME_LENGTH 50
#define MAX_NAMES 100


// Structure for message queue
typedef struct {
    long mtype;       // Message type
    int numWorkers;   // Number of workers brought in
} Message;


// char** select(const char *filename, const char *day, int *count) {
//     FILE *file = fopen(filename, "r");
//     if (file == NULL) {
//         printf("Failed to open the file.\n");
//         return NULL;
//     }

//     char line[MAX_LINE_LENGTH];
//     char **selectedNames = (char **)malloc(MAX_NAMES * sizeof(char *));
//     *count = 0;

//     while (fgets(line, sizeof(line), file) != NULL && *count < MAX_NAMES) {
//         // Extract the name and days from the line
//         char *name = strtok(line, " ");
//         char *days = strtok(NULL, "\n");

//         // Tokenize the days using space delimiter
//         char *token = strtok(days, " ");
//         while (token != NULL) {
//             if (strcmp(token, day) == 0) {
//                 // Allocate memory for the name and store it in the selected names array
//                 selectedNames[*count] = (char *)malloc(MAX_NAME_LENGTH * sizeof(char));
//                 strcpy(selectedNames[*count], name);
//                 (*count)++;
//                 break;
//             }
//             token = strtok(NULL, " ");
//         }
//     }

//     fclose(file);
//     return selectedNames;
// }
int countWorkers(char *fileName, char *word)
{
    FILE *file = fopen(fileName, "r");
    if (file == NULL)
    {
        printf("Error: Unable to open file '%s' for reading.\n", fileName);
        return -1;
    }

    int count = 0;
    char line[100];

    while (fgets(line, sizeof(line), file))
    {
        char *p = line;
        while ((p = strstr(p, word)))
        {
            count++;
            p += strlen(word);
        }
    }

    fclose(file);
    return count;
}
int StartDay(char day [100]){
const char *filename = "workers.txt";
int numbWorkers = countWorkers("workers.txt",day);
printf("%d\n", numbWorkers);
return numbWorkers ;
}
int getNumberOfBuses(int numbWorkers){
    int numOfbuses ;
    if (numbWorkers == 0){numOfbuses = 0;}
    else if (numbWorkers <= MAX_WORKERS_IN_BUS){ numOfbuses = 1;}
    else {numOfbuses= 2;  }
    return numOfbuses;
}
// Function for bus process
void busProcess(int busId, int pipeFd[], int msgQueueId, char **selectedNames, int numWorkers) {
    close(pipeFd[1]); // Close write end of pipe

    // Send signal to parent process
    kill(getppid(), SIGUSR1);

    // Receive worker list from parent process
    
    read(pipeFd[0], selectedNames , sizeof(char**) * MAX_WORKERS_IN_BUS);

    // // Display worker list
    // int length = sizeof(selectedNames) / sizeof(selectedNames[0]);
    // printf("Bus %d Worker List:\n", busId);
    //  if (selectedNames != NULL) {
    //     for (int i = 0; i < length; i++) {
    //         printf("%s\n", selectedNames[i]);
    //         free(selectedNames[i]);  // Free allocated memory for each name
    //     }
    //     free(selectedNames);  // Free the selected names array
    // }

    // Send summary message to parent process
    Message msg;
    msg.mtype = busId;
    msg.numWorkers = MAX_WORKERS_IN_BUS;
    msgsnd(msgQueueId, &msg, sizeof(Message) - sizeof(long), 0);

    close(pipeFd[0]); // Close read end of pipe
    exit(0);
}





// ==============MAIN=================
int main(){
    printf("Welcome to the Spring Festival!\n");
    printf("Please choose a Day to start:\n"); 
    char day[100];
    int count;
    fgets(day, 100, stdin);
    day[strcspn(day, "\n")] = 0;
    int numberOfWorkers = StartDay(day);// number of workers in the seleced day 
    int numOfbuses = getNumberOfBuses(numberOfWorkers); //get number of buses needed
    // char **selectedNames = select("workers.txt", day, &count); // get the names of the workers in the selected day
    // Create message queue
    key_t key = ftok(".", 'm');
    int msgQueueId = msgget(key, IPC_CREAT | 0666);
    // Create pipes
    int pipeFd[2][2];
    for (int i = 0; i < numOfbuses; i++) {
        if (pipe(pipeFd[i]) == -1) {
            perror("pipe");
            return 1;
        }
    }
      // Create buses
      // Fork child processes (buses)
    pid_t childPid;
    for (int i = 0; i < numOfbusesBuses; i++) {
        childPid = fork();
        if (childPid == -1) {
            perror("fork");
            return 1;
        } else if (childPid == 0) {
            // Child process (bus)
            busProcess(i + 1, pipeFd[i], msgQueueId, selectedNames, numberOfWorkers);
        }
    }
      // Parent process
    for (int i = 0; i < numOfbuses; i++) {
        close(pipeFd[i][0]); // Close read end of pipe
    }
    // Wait for signal from child processes
    for (int i = 0; i < numOfbuses; i++) {
        pause();
    }
    // Send worker list to child processes
    for (int i = 0; i < numOfbuses; i++) {
        write(pipeFd[i][1], selectedNames, sizeof(char) * MAX_WORKERS_IN_BUS);
        close(pipeFd[i][1]); // Close write end of pipe
    }
    // Receive summary messages from child processes
    for (int i = 0; i < numOfbuses; i++) {
        Message msg;
        msgrcv(msgQueueId, &msg, sizeof(Message) - sizeof(long), i + 1, 0);
        printf("Bus %ld brought in %d workers.\n", msg.mtype, msg.numWorkers);
    }
    // Clean up message queue
    msgctl(msgQueueId, IPC_RMID, NULL);
    // Wait for child processes to terminate
    for (int i = 0; i < numOfbuses; i++) {
        wait(NULL);
    }



return 0;
}


