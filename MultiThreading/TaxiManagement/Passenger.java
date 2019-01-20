package com.thread;
import java.util.*;

public class Passenger {


    public static enum DESTINATION {
        WHITEFIELD, SARJAPUR, KRPURAM, INDIRANAGAR, MGROAD, HEBBAL, JAYANAGAR, PEENYA, HSRLAYOUT, KORAMANGLA
    }
    public static final DESTINATION[] DESTINATION_VALUES = DESTINATION.values();
    private DESTINATION destination;

    public Passenger(DESTINATION dest){
        destination = dest;
    }
    public DESTINATION getDestination() {
        return destination;
    }
}
