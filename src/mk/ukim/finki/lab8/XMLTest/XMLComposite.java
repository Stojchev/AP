package mk.ukim.finki.lab8.XMLTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLComposite implements XMLComponent {

    String name;
    List<XMLComponent> children;
    Map<String, String> attributesWithValues;

    public XMLComposite(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.attributesWithValues = new HashMap<>();
    }

    @Override
    public void addAttribute(String type, String value) {
        attributesWithValues.put(type, value);
    }

    @Override
    public String printXML(int indent) {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=indent;i++){
            sb.append("\t");
        }
        sb.append("<");
        sb.append(name);
        sb.append(" ");
        for(Map.Entry<String,String> entry : attributesWithValues.entrySet()){
            String key=entry.getKey();
            String value=entry.getValue();
            sb.append(key);
            sb.append("=\"");
            sb.append(value);
            sb.append("\">");
            sb.append("\n");
        }
        for(XMLComponent component:children)
            sb.append(component.printXML(indent+1));
        for(int i=1;i<=indent;i++){
            sb.append("\t");
        }
        sb.append("</");
        sb.append(name);
        sb.append(">\n");
        return sb.toString();
    }

    public void addComponent(XMLComponent trajce) {
        children.add(trajce);
    }
}
