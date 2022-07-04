//package DesignPattern;
//
// //https://dartpad.dev/?id=902cc662673ad8d2df75185dcbcc78a8
//public class Decorator {
//
//    //interface
//    class Cat{
//        void draw(){}
//        void talk(){}
//    }
//
//    class SimpleCat extends Cat{
//        @override
//        void draw(){
//            // Draw cat shape
//        }
//        @override
//        void talk(){
//            print('Im cat');
//        }
//    }
//
//    abstract class CatDecorator implements Cat{
//        final Cat _cat;
//        CatDecorator(this._cat);
//    }
//
//    class CheeseDecoratorCat extends CatDecorator {
//        CheeseDecoratorCat(Cat cat) : super(cat);
//
//        @override
//        void draw(){
//            _cat.draw();
//            _drawCheesePattern();
//        }
//        void _drawCheesePattern(){
//            // Draw Cheese pattern
//        }
//
//        @override
//        void talk(){
//            _cat.talk();
//            print('Im cheese cat');
//        }
//    }
//
//    class OddEyesDecoratorCat extends CatDecorator {
//        OddEyesDecoratorCat(Cat cat) : super(cat);
//
//        @override
//        void draw(){
//            _cat.draw();
//            _drawOddEyes();
//        }
//        void _drawOddEyes(){
//            // Draw Odd eyes
//        }
//
//        @override
//        void talk(){
//            _cat.talk();
//            print('Im Odd eyes cat');
//        }
//    }
//
//
//    void main() {
//        Cat decoratedCat = OddEyesDecoratorCat(CheeseDecoratorCat(SimpleCat()));
//        decoratedCat.talk();
//    }
//
//}
