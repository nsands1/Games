/**
 * utils.c
 */

#include <stdlib.h>
#include <time.h>
#include "utils.h"

// Sleep function //
void sleep_ms(int milliseconds) {
    clock_t start_time = clock();
    while(clock() < start_time + milliseconds * CLOCKS_PER_SEC / 1000); // milliseconds units to seconds units (1000:1)
}

// Generate a random integer between min and max
int random_int(int min, int max) {
    return min + rand() % (max - min + 1);
}
