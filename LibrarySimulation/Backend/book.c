/**
 * book.c
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "book.h"

// Initializes a book with a given title // 
void init_book(Book *book, const char *title) {
    if (book != NULL && title != NULL) {
        strncpy(book->title, title, sizeof(book->title) - 1);   // Copy the title
        book->title[sizeof(book->title) - 1] = '\0';    // Ensure null-terminated string
    }
}

// Prints the detatils of a book (current just a title, for use in debuggin or display purposes) //
void print_book(const Book *book) {
    if (book != NULL) {
        printf("Book Title: s\n", book->title);
    }
}

