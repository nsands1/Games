/**
 *  game.h
 */

#ifndef GAME_H
#define GAME_H

#include "library.h"
#include "patron.h"

void start_game();      // Starts the game
void serve_patron();    // Serve a patron with a book request
void update_time();     // Update the game time and patron queue

#endif