package package1;

import java.time.Year;

public class Bmi {

    int id;
    String name;
    String yob;
    int height;
    int weight;
    double bmi;
    String category;
    String recommendation;
    int age;

    public Bmi(int id, String name, String yob, int height, int weight) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public String getCategory() {
        return category;
    }

    public int getAge() {
        return age;
    }

    public String getRecommendation() {
        return recommendation;
    }
    
    

    public void calculate() {
        double heightInM = height / 100;
        double heightSq = heightInM * heightInM;
        bmi = weight / heightSq;

        age = 2024 - Integer.parseInt(yob);
    }

    public void display() {
        if (bmi < 16) {
            category = "Severe undernourishment";
            recommendation = "you need Immediate medical attention and nutritional support";
        } else if (bmi > 16 && bmi < 16.9) {
            category = "Medium undernourishment";
            recommendation ="you need balanced diet rich in nutrients, supplemented with regular meals and hydration";
        } else if (bmi > 17 && bmi < 18.4) {
            category = "Slight undernourishment";
            recommendation = "focus on increasing nutrient-dense foods in your diet";
        } else if (bmi > 18.5 && bmi < 24.9) {
            category = "Normal nutrition state";
            recommendation = "continue to prioritize a balanced diet consisting";
        } else if (bmi > 25 && bmi < 29.9) {
            category = "Overweight";
            recommendation = "need regular physical activity and seeking support from healthcare professionals ";
        } else if (bmi > 30 && bmi < 39.9) {
            category = "Obesity";
            recommendation = "do regular exercise and make behavioral changes";
        } else if (bmi > 40) {
            category = "Pathological obesity";
            recommendation = "seek immediate medical attention and guidance from healthcare professionals";
        }
    }

}
