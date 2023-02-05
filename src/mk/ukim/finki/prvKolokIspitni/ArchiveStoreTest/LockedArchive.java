package mk.ukim.finki.prvKolokIspitni.ArchiveStoreTest;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

public class LockedArchive extends Archive {
    private Date dateToOpen; //datum do koj ne smee da se otvori

    public LockedArchive(int id, Date dateToOpen) {
        super(id);
        this.dateToOpen = dateToOpen;
    }

    public Date getDateToOpen() {
        return dateToOpen;
    }

    @Override
    public String getType() {
        return "LockedArchive";
    }
}
