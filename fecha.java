public class Fecha{
  private int day,month,year;

  void iniDate(){
    day = 0;
    month = 0;
    year = 0;
  }

  public boolean setDay(int day){
    day = d;
  }
  public boolean setMonth(int month){
    month = m;
  }
  public boolean setYear(int year){
    year = y;
  }

  public int getDay(){
    return day;
  }
  public int getMonth(){
    return month;
  }
  public int getYear(){
    return year;
  }

  private boolean leapYear(){
    return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
  }

  public boolean rightYear(){
    return (year >= 1900 && <= 2100);
  }
  public boolean rightMonth(){
    return (month > 0 && <= 12);
  }
  public boolean rightDay(){
    boolean rDay;

    switch(month){
      case 2:
        if(leapYear()){
            return (day >= 1 && day <= 29);
        }else{
          return (day >= 1 && day <= 28);
        }
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        return (day >= 1 && day <= 30);
        break;
      default:
        return (day >= 1 && day <= 31);
    }
  }

  public void yearDays(){
    int i = 0;

    while(i <= 12){
      if(i != month){
        switch(month){
          case 1:
            day = day + 31; break;
          case 2:
            if(leapYear()){
              day = day + 29; break;
            }else{
                day = day + 28; break;
            }
          case 3:
            day = day + 31; break;
          case 4:
            day = day + 30; break;
          case 5:
            day = day + 31; break;
          case 6:
            day = day + 30; break;
          case 7:
            day = day + 31; break;
          case 8:
            day = day + 31; break;
          case 9:
            day = day + 30; break;
          case 10:
            day = day + 31; break;
          case 11:
            day = day + 30; break;
          case 12:
            day = day + 31; break;
        }
      }
      i++;
    }
  }

  public void nexDay(){
    day++;

    if(!rightDay() && !rightMonth() && !rightYear()){
      day = 1;
      month ++;
      if(!rightDay() !rightMonth() && !rightYear()){
        month = 1;
        year ++;
      }
    }
  }

  public void days(){
    if(leapYear()){
      switch(month){
        case 2:
          day = 29 - day; break;
        case 4:
        case 6:
        case 9:
        case 11:
          day = 30 - day; break;
        default:
          day = 31 - day; break;
      }
      yearDays();
    }else{
      switch(month){
        case 2:
          day = 28 - day; break;
        case 4:
        case 6:
        case 9:
        case 11:
          day = 30 - day; break;
        default:
          day = 31 - day; break;
      }
      yearDays();
    }
  }

}
