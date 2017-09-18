import java.io.Serializable;

public class Q22 implements Serializable {
  protected transient String name = "Bridget";

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Q22() {
    this.name = "Matt";
  }
}

class Eagle extends Q22 implements Serializable {
  {
    this.name = "Janette";
  }

  public Eagle() {
    this.name = "Daniel";
  }
}
