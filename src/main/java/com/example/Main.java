package com.example;

import com.example.models.*;

public class Main {
    public static void main(String[] args) {
        // Crée des disciplines
        Discipline swimming = new Discipline(1, "Swimming", "Swimming description");
        Discipline running = new Discipline(2, "Running", "Running description");
        // Crée un athlète
        Athlete athlete = new Athlete(1, "Doe", "John", "USA", 'M', 25, null);

        // Ajoute des disciplines à l'athlète
        athlete.addDiscipline(swimming);
        athlete.addDiscipline(running);

        // Affiche les informations de l'athlète et ses disciplines
        System.out.println("Athlete: " + athlete.getFirstName() + " " + athlete.getLastName());
        System.out.println("Disciplines:");
        for (Discipline discipline : athlete.getDiscipline()) {
            System.out.println("- " + discipline.getName());
        }
    }
}
