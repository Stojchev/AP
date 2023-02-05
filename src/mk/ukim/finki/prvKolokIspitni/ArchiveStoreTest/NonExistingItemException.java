package mk.ukim.finki.prvKolokIspitni.ArchiveStoreTest;

class NonExistingItemException extends Exception{
    public NonExistingItemException(String message) {
        super(message);
    }
}