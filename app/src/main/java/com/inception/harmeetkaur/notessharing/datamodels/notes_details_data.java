package com.inception.harmeetkaur.notessharing.datamodels;

/**
 * Created by Harmeet kaur on 11-04-2018.
 */

public class notes_details_data {

  public    String title , description , department , session , type , time ;


  public   notes_details_data()
    {

    }

    public notes_details_data(String title , String description , String department , String session , String type)
    {
        this.title = title;

        this.description = description;

        this.department = department;

        this.session = session ;

        this.type = type ;
    }

    public notes_details_data(String title , String description , String department , String session , String type , String time)
    {
        this.title = title;

        this.description = description;

        this.department = department;

        this.session = session ;

        this.type = type ;

        this.time = time ;
    }
}
