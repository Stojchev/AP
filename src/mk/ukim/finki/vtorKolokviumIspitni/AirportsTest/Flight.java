package mk.ukim.finki.vtorKolokviumIspitni.AirportsTest;

//public class Flight {
//    String from;
//    String to;
//    String timeTakeOff;
//    String timeLand;
//    String duration;
//
//    public Flight(String from, String to, int time, int duration) {
//        this.from = from;
//        this.to = to;
//        this.timeTakeOff=String.format("%02d:%02d",time/60,time%60);
//        if(time+duration<=1440){
//            if(time%60+duration%60<=60)
//                this.timeLand=String.format("%02d:%02d",(time/60+duration/60),time%60+duration%60);
//            else this.timeLand=String.format("%02d:%02d",(time/60+duration/60+1),(time%60+duration%60-60));
//            this.duration=String.format("%dh%02dm",duration/60,duration%60);
//        }
//        else{
//            if(time%60+duration%60<=60)
//                this.timeLand=String.format("%02d:%02d",(time/60+duration/60-24),time%60+duration%60);
//            else this.timeLand=String.format("%02d:%02d",(time/60+duration/60+1-24),(time%60+duration%60-60));
//            this.duration=String.format("+%dd %dh%02dm",(duration+time)/1440,duration/60,duration%60);
//        }
//    }
//
//    public String getFrom() {
//        return from;
//    }
//
//    public String getTo() {
//        return to;
//    }
//
//    public String getTimeTakeOff() {
//        return timeTakeOff;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%s-%s %s-%s %s",from,to,timeTakeOff,timeLand,duration);
//    }
//}
