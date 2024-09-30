#include <gtk/gtk.h>
#include <stdlib.h>
#include <string.h>
#include "game.h"

// Global variables to track GTK widgets //
GtkWidget *time_label;
GtkWidget *patron_label;
GtkWidget *serve_button;
GtkWidget *status_label;
int is_game_active = 0;

void start_game_callback(GtkWidget *widget, gpointer data);
void serve_patron_callback(GtkWidget *widget, gpointer data);
gboolean update_time_callback(gpointer data);

int main(int argc, char *argv[]) {
    gtk_init();

    // Create main window //
    GtkWidget *window = gtk_window_new();
    gtk_window_set_title(GTK_WINDOW(window), "Librarian Simulator");
    gtk_window_set_default_size(GTK_WINDOW(window), 800, 600);
    g_signal_connect(window, "close-request", G_CALLBACK(gtk_main_quit), NULL);

    // Create layout container (GTK 4 uses GtkBox instead of GtkVBox) //
    GtkWidget *vbox = gtk_box_new(GTK_ORIENTATION_VERTICAL, 10);
    gtk_window_set_child(GTK_WINDOW(window), vbox);

    // Time Label //
    time_label = gtk_label_new("Time: 0");
    gtk_box_append(GTK_BOX(vbox), time_label);

    // Patron Queue Label //
    patron_label = gtk_label_new("No patrons currently.");
    gtk_box_append(GTK_BOX(vbox), patron_label);

    // Serve Button //
    serve_button = gtk_button_new_with_label("Serve Patron");
    g_signal_connect(serve_button, "clicked", G_CALLBACK(serve_patron_callback), NULL);
    gtk_box_append(GTK_BOX(vbox), serve_button);

    // Status Label (for feedback) //
    status_label = gtk_label_new("Welcome to the Librarian Simulator!");
    gtk_box_append(GTK_BOX(vbox), status_label);

    // Start/Restart Button //
    GtkWidget *start_button = gtk_button_new_with_label("Start Game");
    g_signal_connect(start_button, "clicked", G_CALLBACK(start_game_callback), NULL);
    gtk_box_append(GTK_BOX(vbox), start_button);

    // Show all widgets and run the main loop //
    gtk_widget_show(window);
    gtk_main();

    return 0;
}

// Callback to start the game //
void start_game_callback(GtkWidget *widget, gpointer data) {
    if (!is_game_active) {
        is_game_active = 1;
        start_game();  // Start back-end game logic //
        gtk_label_set_text(GTK_LABEL(status_label), "Game Started! Serve patrons.");
        g_timeout_add_seconds(5, update_time_callback, NULL);  // Update time every 5 seconds //
    }
}

// Callback to serve a patron //
void serve_patron_callback(GtkWidget *widget, gpointer data) {
    serve_patron();  // Call the back-end logic to serve a patron //
    gtk_label_set_text(GTK_LABEL(status_label), "Patron served!");
}

// Callback to update game time in the GUI
gboolean update_time_callback(gpointer data) {
    char time_str[50];
    sprintf(time_str, "Time: %d", game_time);  // game_time is from the back-end //
    gtk_label_set_text(GTK_LABEL(time_label), time_str);

    // Update patron queue display //
    char patron_str[256];
    sprintf(patron_str, "Patrons: ");
    for (int i = 0; i < MAX_PATRONS; i++) {
        if (patrons[i].is_active) {
            strcat(patron_str, patrons[i].requested_book.title);
            strcat(patron_str, ", ");
        }
    }
    gtk_label_set_text(GTK_LABEL(patron_label), patron_str);

    return TRUE;  // Continue updating every 5 seconds //
}
