package mk.ukim.finki.prvKolokIspitni.ArchiveStoreTest;

import java.time.LocalDate;
import java.util.Date;

public class SpecialArchive extends Archive {
    int maxOpen; //maksimalen broj dozvoleni otvaranja
    int copyOfMaxOpen;

    public SpecialArchive(int id, int maxOpen) {
        super(id);
        this.maxOpen = maxOpen;
        copyOfMaxOpen = maxOpen;
    }

    public int getCopyOfMaxOpen() {
        return copyOfMaxOpen;
    }

    public int getMaxOpen() {
        return maxOpen;
    }

    public void open(){
        maxOpen --;
    }

    @Override
    public String getType() {
        return "SpecialArchive";
    }
}
