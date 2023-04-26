package cz.cvut.fel.ts1;

import java.util.ArrayList;

public class Main {

    private ArrayList<String> strings;

    public Main( ArrayList<String> list ) {
        strings = list;
    }


    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add( "Something" );
        list.add( "to" );
        list.add( "add" );
        Main newMain = new Main( list );
        System.out.println( newMain.getStrings() );
    }

    public ArrayList<String> getStrings() {
        return strings;
    }
}
