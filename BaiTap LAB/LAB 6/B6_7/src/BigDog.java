class BigDog extends Dog {
    @Override
    public void greeting() {
        System.out.println("WOOOF!");
    }

    @Override
    public void greeting(Dog another) {
        System.out.println("WOOOOOF!");
    }

    public void greeting(BigDog another) {
        System.out.println("WOOOOOOOOF!");
    }
}
