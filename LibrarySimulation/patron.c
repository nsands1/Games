/**
 * patron.c
 */

#include <stdio.h>
#include <stdlib.h>
#include "patron.h"
#include "utils.h"

// Adds a new patron with a random book request to the queue //
void add_patron(Patron patrons[], int max_patrons) {
    for (int i = 0; i < max_patrons; i++) {
        if (!patrons[i].is_active) {
            patrons[i].is_active = 1;
            patrons[i].requested_book = get_random_book();
            printf("A new patron arrived!\n They want the book '%s'.\n\n", patrons[i].requested_book.title);
            return;
        }
    }

    printf("Patron queue is fill!\n");
}