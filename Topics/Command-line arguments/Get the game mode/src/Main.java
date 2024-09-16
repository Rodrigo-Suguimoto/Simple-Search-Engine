class Problem {
    public static void main(String[] args) {
        String gameMode = "default";

        for (int i = 0; i < args.length; i++) {
            if (i + 1 < args.length && args[i].equals("mode") && i % 2 == 0) {
                gameMode = args[i + 1];
            }
        }

        System.out.println(gameMode);
    }
}