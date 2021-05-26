public enum PeopleType {
    HUMAN(Human.class), SWAMPER(Swamper.class), WOODMAN(Woodman.class);

    Class peopleClass;

    PeopleType(Class peopleClass) {
        this.peopleClass = peopleClass;
    }
}
