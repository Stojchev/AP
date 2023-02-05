package mk.ukim.finki.prvKolokIspitni.ArchiveStoreTest;

import java.time.LocalDate;
import java.util.Date;

abstract class Archive {
    protected int id;
    protected Date dateArchived;

    public Archive(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Date getDateArchived() {
        return dateArchived;
    }

    public void setDateArchived(Date dateArchived) {
        this.dateArchived = dateArchived;
    }

    public abstract String getType();
}
