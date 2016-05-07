package com.example.cornelious.busbooking.domain.passenger;

import java.io.Serializable;

/**
 * Created by Cornelious on 4/16/2016.
 */
public class Passenger implements Serializable {
    private Long passNumber;
    private String idNumber;
    private String name;
    private String lastName;
    private  PassengerAddress objAdress;
    private Passenger(PassengerBuilder objBuilder)
    {
        this.passNumber=objBuilder.passNumber;
        this.idNumber = objBuilder.idNumber;
        this.name=objBuilder.name;
        this.lastName=objBuilder.lastName;
        this.objAdress=objBuilder.objAdress;
    }

    public Long getPassNumber() {
        return passNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public PassengerAddress getObjAdress() {
        return objAdress;
    }

    public static class PassengerBuilder
    {
        private Long passNumber;
        private String idNumber;
        private String name;
        private String lastName;
        private  PassengerAddress objAdress;

        public PassengerBuilder passNumber(Long passNo)
        {
            this.passNumber=passNo;
            return this;
        }
        public PassengerBuilder id(String idNumber)
        {
            this.idNumber=idNumber;
            return this;
        }
        public PassengerBuilder name(String name)
        {
            this.name=name;
            return this;
        }
        public PassengerBuilder lastName(String lastName)
        {
            this.lastName=lastName;
            return this;
        }
        public PassengerBuilder address(PassengerAddress objAdress)
        {
            this.objAdress=objAdress;
            return this;
        }
        public PassengerBuilder copy(Passenger objPassenger)
        {
            this.passNumber=objPassenger.passNumber;
            this.idNumber=objPassenger.idNumber;
            this.name=objPassenger.name;
            this.lastName=objPassenger.lastName;
            this.objAdress=objPassenger.objAdress;
            return  this;
        }
        public Passenger build()
        {
            return new Passenger(this);
        }


    }
}
