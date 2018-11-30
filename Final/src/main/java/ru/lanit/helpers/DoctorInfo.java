package ru.lanit.helpers;

import  ru.lanit.domain.*;
import  java.util.List;

public class DoctorInfo
{
    private long         count;
    private String       message;
    private List<Doctor> doctors;

        public DoctorInfo(){}
        public DoctorInfo ( int count, List<Doctor> doctors, String message )
        {
            this.setCount   ( count );
            this.setDoctors ( doctors );
            this.setMessage ( message );
        }
        public long getCount() { return this.count; }
        public void setCount(long count) { this.count = count; }
        public String getMessage() { return this.message; }
        public void setMessage(String message) { this.message = message; }
        public List<Doctor> getDoctors() { return this.doctors; }
        public void setDoctors(List<Doctor> doctors) { this.doctors = doctors; }

}
