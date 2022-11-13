package com.laborator_IS.resurse.utils.initialization;

import com.laborator_IS.resurse.constants.ComponentType;
import com.laborator_IS.resurse.constants.MotorType;
import com.laborator_IS.resurse.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MockDataRepo {

    private static final Long noOfEntities=3L;

    public List<Address> initAddress(){
        List<Address> addresses=new LinkedList<>();
        for(Long i=0L;i<noOfEntities;i++ ){
            addresses.add(Address.builder().city("Cluj-Napoca").street("Calea Turzii").number(i).build());
        }
        return addresses;
    }

    public List<Contact> initContact(){
        List<Contact> contacts=new LinkedList<>();
        for(int i=0;i<noOfEntities;i++){
            contacts.add(Contact.builder().email("Email_"+i).fax("Fax_"+i).phoneNumber("PhoneNr_"+i).build());
        }
        return contacts;
    }

    public List<Engine> initEngines(){
        List<Engine> engines=new LinkedList<>();
        engines.add(Engine.builder().horsePower(100L).type(MotorType.GAS).build());
        engines.add(Engine.builder().horsePower(177L).type(MotorType.DIESEL).build());
        engines.add(Engine.builder().horsePower(112L).type(MotorType.ELECTRIC).build());
        return engines;
    }

    public List<CarComponent> initCarComponents(){
        List<CarComponent> components=new LinkedList<>();
        String[] colors={"green","red","blue","violet"};
        Random r=new Random();

        for(int i=0;i<noOfEntities;i++){
            int randomNumber=r.nextInt(colors.length);
            components.add(CarComponent.builder()
                    .color(colors[randomNumber])
                    .type(ComponentType.randomType()).price(randomNumber*1000L).build());
        }
        return components;
    }

    public List<Car> initCars(){
        List<Car> cars =new LinkedList<>();
        Random r=new Random();
        for(int i=0;i<noOfEntities;i++){
            List<CarComponent> shuffledComponents=initCarComponents();
            List<Engine> engines=initEngines();
            Collections.shuffle(shuffledComponents);
            shuffledComponents.forEach(carComponent -> carComponent.setId(null));
            cars.add(Car.builder()
                    .engine(engines.get(i% engines.size()))
                    .components(shuffledComponents.subList(0,r.nextInt(Math.toIntExact(noOfEntities))))
                    .maker("Maker_"+i).build());
        }
        return cars;
    }

    public List<Owner> initOwners(List<Address> addresses, List<Contact> contacts){
        List<Owner> owners=new LinkedList<>();
        for(int i=0;i<noOfEntities;i++){
            List<Car> cars=initCars();
            owners.add(Owner.builder().address(addresses.get(i))
                    .contact(contacts.get(i))
                    .name("Nume_"+i)
                    .cars(cars).build());
        }
        return owners;
    }
}
