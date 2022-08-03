package this_is_java.final_keyword_extends2;

public class Parent {

    protected final String parentField;

    protected final String getParentField(){
        return parentField;
    }

    protected Parent(String parentField) { // 자식 클래스에서 초기화 가능
        this.parentField = parentField;
    }
}
