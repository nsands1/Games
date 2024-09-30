#ifndef LIBRARY_H
#define LIBRARY_H

#include "book.h"

#define MAX_BOOKS 10

typedef struct {
    Book books[MAX_BOOKS];
    int book_count;
} Library;

void init_library(Library *library);
void generate_books(Library * library);
Book get_random_book();

#endif