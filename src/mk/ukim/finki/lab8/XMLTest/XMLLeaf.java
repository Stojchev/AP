package mk.ukim.finki.lab8.XMLTest;

public class XMLLeaf implements XMLComponent {
    String name;
    String lastName;
    //Map<String, String> attributesWithValues;

    public XMLLeaf(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        //this.attributesWithValues = new HashMap<>();
    }

    @Override
    public void addAttribute(String type, String value) {
        //attributesWithValues.put(type, value);
    }

    @Override
    public String printXML(int indent) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=indent;i++){
            sb.append("\t");
        }
        sb.append("<");
        sb.append(name);
        sb.append(">");
        sb.append(lastName);
        sb.append("/<");
        sb.append(name);
        sb.append(">");
        sb.append("\n");
        return sb.toString();
    }

}
