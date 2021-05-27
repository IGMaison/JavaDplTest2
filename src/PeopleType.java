public enum PeopleType {
    HUMAN(Human.class), SWAMPER(Swamper.class), WOODMAN(Woodman.class);

    Class peopleClass;

    PeopleType(Class peopleClass) {
        this.peopleClass = peopleClass;
    }

   static PeopleType fromString (String peopleType){

        try {
            PeopleType.valueOf(peopleType.toUpperCase());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("No PeopleType");
        }
        return PeopleType.valueOf(peopleType.toUpperCase());
   }
}
