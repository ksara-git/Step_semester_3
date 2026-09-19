#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node {
    char song[50];
    struct Node *prev;
    struct Node *next;
};

struct Node *head = NULL;
struct Node *tail = NULL;
struct Node *current = NULL;

// Add song at end
void addSong(char name[]) {
    struct Node *newNode;

    newNode = malloc(sizeof(struct Node));

    strcpy(newNode->song, name);
    newNode->prev = NULL;
    newNode->next = NULL;

    if (head == NULL) {
        head = tail = current = newNode;
    }
    else {
        tail->next = newNode;
        newNode->prev = tail;
        tail = newNode;
    }

    printf("Song added: %s\n", name);
}

// Play next song
void nextSong() {
    if (current == NULL) {
        printf("Playlist is empty\n");
    }
    else if (current->next == NULL) {
        printf("No next song\n");
    }
    else {
        current = current->next;
        printf("Playing: %s\n", current->song);
    }
}

// Play previous song
void previousSong() {
    if (current == NULL) {
        printf("Playlist is empty\n");
    }
    else if (current->prev == NULL) {
        printf("No previous song\n");
    }
    else {
        current = current->prev;
        printf("Playing: %s\n", current->song);
    }
}

// Delete song by name
void deleteSong(char name[]) {
    struct Node *temp = head;

    while (temp != NULL && strcmp(temp->song, name) != 0) {
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Song not found\n");
        return;
    }

    if (temp == current) {
        if (temp->next != NULL)
            current = temp->next;
        else
            current = temp->prev;
    }

    if (temp->prev != NULL)
        temp->prev->next = temp->next;
    else
        head = temp->next;

    if (temp->next != NULL)
        temp->next->prev = temp->prev;
    else
        tail = temp->prev;

    free(temp);

    printf("Song deleted\n");
}

// Display forward
void showForward() {
    struct Node *temp = head;

    printf("\nPlaylist Forward:\n");

    while (temp != NULL) {
        if (temp == current)
            printf("[Playing] ");

        printf("%s -> ", temp->song);
        temp = temp->next;
    }

    printf("NULL\n");
}

// Display backward
void showBackward() {
    struct Node *temp = tail;

    printf("\nPlaylist Backward:\n");

    while (temp != NULL) {
        printf("%s -> ", temp->song);
        temp = temp->prev;
    }

    printf("NULL\n");
}

int main() {
    addSong("Song A");
    addSong("Song B");
    addSong("Song C");
    addSong("Song D");

    showForward();
    showBackward();

    printf("\nCurrent Song: %s\n", current->song);

    nextSong();
    nextSong();

    previousSong();

    deleteSong("Song B");

    showForward();
    showBackward();

    return 0;
}