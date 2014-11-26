class Box{
  private double length;
  private double breadth;
  private double height;
  
  public double getVolume(){
         return length * breadth * height;
  }
  void setLength( double length ){
          this.length = length;
  }
  void setBreadth( double breadth ){
          this.breadth = breadth;
  }
  void setHeight( double height ){
          this.height = height;
  }
  Box sumBoxVol(Box b){
     Box box = new Box();
     box.length = this.length + b.length;
     box.breadth = this.breadth + b.breadth;
     box.height = this.height + b.height;
     return box;
  }
}

public class Test{
  public static void main(String[] args){
     Box box1 = new Box();
     Box box2 = new Box();
   
     box1.setLength(2.0); 
     box1.setBreadth(3.0); 
     box1.setHeight(4.0);
   
     box2.setLength(3.0); 
     box2.setBreadth(4.0); 
     box2.setHeight(5.0);
   
     System.out.println(box1.getVolume());  // box1 volume 출력
     System.out.println(box2.getVolume());  // box2 volume 출력

     // box1, box2 volume 합 출력
     System.out.println(box1.sumBoxVol(box2).getVolume());    
  }
}