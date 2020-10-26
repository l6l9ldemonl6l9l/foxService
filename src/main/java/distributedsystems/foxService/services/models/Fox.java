package distributedsystems.foxService.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Table;

@EnableAutoConfiguration
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Fox extends FairyAnimal {

    @Column(unique = true)
    private int sizeCunning;


    public Fox(String name, Date lastLunchTime, int energy, int sizeCunning) {
        super(name, lastLunchTime, energy);
        this.sizeCunning = sizeCunning;
    }

    public void training() {
        fatigue();
        sizeCunning += 2;
    }

    public void voiceVin() {
        System.out.println("Лиса: Голубушка, как хороша!\n Ну что за шейка, что за глазки!\n Рассказывать, так, право, сказки!\nКакие перышки! какой носок!\nИ, верно, ангельский быть должен голосок!\nСпой, светик, не стыдись!\nЧто ежели, сестрица,\nПри красоте такой и петь ты мастерица,\nВедь ты б у нас была царь-птица!");
    }

    public void voiceFail() {
        System.out.println("Лиса: Ушла");
    }

    public void showInformationAboutFox() {
        System.out.print("Лиса ");
        showInformation();
        System.out.println(" Текущая хитррость: " + sizeCunning + ".");
    }

    public int getSizeCunning() {
        return sizeCunning;
    }

}
