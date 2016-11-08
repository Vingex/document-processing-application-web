/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generators;

import Staffs.Person;
import java.util.Random;

/**
 *
 * @author Алексей
 */
public class PeopleGenerate { //генерируем ФИО из заданных массивов имен фамлий и отчеств, оставляем только мужские имена, из за конфликта окончаний фамилий и отчеств
    String Names[];
    String Surname[];
    String Patronymic[];
    String Positions[];
    Random random;
    int id;
    
    public PeopleGenerate(){
        random = new Random();
        Names = new String[] {"Сергей", "Дмитрий", "Виталий", "Иван", "Александр", "Алексей"};
        Surname = new String[] {"Иванов", "Кузнецов", "Попов", "Соколов", "Новиков", "Волков", "Павлов", "Орлов", "Борисов"};
        Patronymic = new String[] {"Сергеевич", "Дмитриевич", "Виталиевич", "Иванович", "Александрович", "Алексеевич"};
        Positions = new String[] {"manager", "programmer","accountant"};
        id = 0;
    }
    
    public String RandomMan(){
        String NSP = Surname[random.nextInt(Surname.length-1)]+" "+Names[random.nextInt(Names.length-1)]+" "+Patronymic[random.nextInt(Patronymic.length-1)];
        return NSP;
    }
    
    public String [] RandomsPeople(int count){
        String[] people = new String[count];
        for(int i=0; i<count; i++)
            people[i]=RandomMan();
        return people;
    }
    
    public Person RandomPerson(){
        Person person = new Person();
        person.setName(Names[random.nextInt(Names.length-1)]);
        person.setSurname(Surname[random.nextInt(Surname.length-1)]);
        person.setPatronymic(Patronymic[random.nextInt(Patronymic.length-1)]);
        person.setPosition(Positions[random.nextInt(Positions.length-1)]);
        person.setidentifier(id);
        id++;
        return person;
    }
    

}
