//package mk.ukim.finki.prvKolokIspitni.ArchiveStoreTest;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ArchiveStore {
//    List<Archive> archives;
//    StringBuilder log;
//
//    public ArchiveStore() {
//        archives = new ArrayList<>();
//        this.log = new StringBuilder();
//    }
//
//    public void archiveItem(Archive item, Date date){
//        item.setDateArchived(date);
//        archives.add(item);
//        log.append("Item "+item.getId()+" archived at "+date+"\n");
//    }
//
//    public void openItem(int id, Date date) throws NonExistingItemException {
//        if (archives.stream().noneMatch(archive -> archive.getId()==id))
//            throw new NonExistingItemException("Item with id "+id+" doesn't exist");
//
//        for (Archive a:archives){
//            if (a.getId() == id){
//                if (a.getType().equals("LockedArchive")){
//                    LockedArchive la = (LockedArchive) a;
//                    if (la.getDateArchived().before(la.getDateToOpen()))
//                        log.append("Item "+id+" cannot be opened before "+la.getDateToOpen()+"\n");
//                    else
//                        log.append("Item "+id+" opened at "+date+"\n");
//                }else{
//                    SpecialArchive sa = (SpecialArchive) a;
//                    if (sa.getMaxOpen() == 0)
//                        log.append("Item "+id+" cannot be opened more than "+sa.getCopyOfMaxOpen()+" times\n");
//                    else{
//                        log.append("Item "+id+" opened at "+date+"\n");
//                        sa.open();
//                    }
//                }
//            }
//        }
//    }
//
//    public String getLog() {
//        return log.toString().replaceAll("GMT","UTC");
//    }
//}
