#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "game.h"
#include "utils.h"

#define MAX_PATRONS 5
#define GAME_DURATION 60    // # = seconds of game duration

int game_time = 0;
Library library;
Patron patrons[MAX_PATRONS];

// Main Game Loop Starts Here //
void start_game() {
    printf("Hello World!\n");
    printf("Welcome to the Librarian Simulator!\n");
    init_library(&library);
    generate_books(&library);
    
    srand(time(NULL));
    int playing = 1;
    while (playing && game_time < GAME_DURATION) {
        printf("Game Time: %d seconds\n", game_time);
        if (game_time % 10 == 0) {
            add_patron(patrons, MAX_PATRONS);
        }

        serve_patron();
        update_time();
        if (game_time >= GAME_DURATION) {
            printf("Time's up! Game Over\n");
            playing = 0;
        }
    }
}

// Serving a patron from the patron queue //
void serve_patron() {
    for (int i = 0; i < MAX_PATRONS; i++) {
        if (patrons[i].is_active) {
            printf("Serving Patron %d: \n They requested '%s' .\n\n", i, patrons[i].requested_book.title);
            printf("Enter 1 to serve, 0 to skip: ");
            int choice;
            
            scanf("%d", &choice);
            if (choice == 1) {
                printf("Book '%s' successfully lent to Patron %d. \n", patrons[i].requested_book.title, i);
                patrons[i].is_active = 0;   // Patron has been served //
            }
        }
    }
}

// Increment game time by adding seconds //
void update_time() {
    game_time += 5;     // Increment time by 5 seconds //
    sleep_ms(500);      // Simulate passage of time //
}