#ifndef PATRON_H
#define PATRON_H

#include "book.h"

typedef struct {
    int is_active;  // Active in the queue? //
    Book requested_book;    // Book the patron has requested //
} Patron;

void add_patron(Patron patrons[], int max_patrons);;    // Adds a new patron to the queue not to exceed max_patrons //

#endif

