class Program {

    public static void main (String[] args) {
            Crew spaceship = new Crew();
            System.out.println(spaceship.check());
            System.out.println(spaceship.work);
            for (int i = 0; i < 7; i++) {
                spaceship.drink();
            }
            System.out.println(spaceship.work);
            System.out.println(spaceship.check());
            for (int j = 0; j < 3; j++) {
                spaceship.drink();
            }
            System.out.println(spaceship.work);
            System.out.println(spaceship.score());
            System.out.println(spaceship.check());
        }

}