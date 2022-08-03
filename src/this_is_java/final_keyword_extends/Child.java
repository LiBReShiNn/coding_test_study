package this_is_java.final_keyword_extends;

import this_is_java.final_keyword_extends2.Parent;

public class Child extends Parent {

    String childField;

    // final field는 반드시 생성자를 통해 초기화 되어야 한다.
    // 자식 객체에서 부모의 final 필드를 초기화 한다.
    public Child(String parentField, String childField) {
        super(parentField);
        this.childField = childField;
    }

    public String ChildMethod() {
        return childField + getParentField();
    }

//    @Override
//    public String getParentField() {
//        // 컴파일 에러
//        // make Parent.getParentField not final
//    }
}
