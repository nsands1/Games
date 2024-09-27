/**
 * library.c
 */

#include <stdio.h>
#include <stdlib.h>
#include "library.h"
#include "utils.h"

// Initialize the library and initial book count //
void init_library(Library *library) {
    library->book_count = 0;
}

// Generate some random books for the library to have //
void generate_books(Library *library) {
    char *titles[] = { "1984", "Moby Dick", "Hamlet", "The Odyssey", "war and Peace" };
    for (int i = 0; i < MAX_BOOKS; i++) {
        Book new_book;
        snprintf(new_book.title, sizeof(new_book.title), "%s", titles[i % 5]);
        library->books[library->book_count++] = new_book;
    }
}

// Get a random book from the library catalog //
Book get_random_book() {
    Library library;
    generate_books(&library);
    int random_index = rand() % library.book_count;
    return library.books[random_index];
}
