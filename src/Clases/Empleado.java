package Clases;

public class Empleado extends Persona {

    private int salario_base;
    private int HED;
    private int HEN;
    private String departamento;

    public Empleado(String nombres, String apellidos, String cedula, String direccion, String email, int celular, int telefono_fijo, int salario_base, int HED, int HEN, String genero, String departamento) {
        super(nombres, apellidos, cedula, direccion, email, celular, telefono_fijo, genero);
        this.salario_base = salario_base;
        this.HED = HED;
        this.HEN = HEN;
        this.departamento = departamento;
    }

    public int getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(int salario_base) {
        this.salario_base = salario_base;
    }

    public int getHED() {
        return HED;
    }

    public void setHED(int HED) {
        this.HED = HED;
    }

    public int getHEN() {
        return HEN;
    }

    public void setHEN(int HEN) {
        this.HEN = HEN;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    //CALCULOS
    public double getSalario_final() {
        return getSalario_base() + getValorHED() + getValorHEN() + getSubTras()  - getAportes();
    }

    public double getValorHED() {
        return getHED() * (getvalorH()* 1.25);
    }

    public double getValorHEN() {
        return getHED() * (getvalorH()* 1.75);
    }

    public double getPension() {
        if (getDepartamento() == "Gerencia") {
            return getSalario_base() * 0.012;
        } else if (getDepartamento() == "Administración") {
            return getSalario_base() * 0.012;
        } else {
            return getSalario_base() * 0.04;
        }
    }

    public double getSalud() {
        if (getDepartamento() == "Gerencia") {
            return getSalario_base() * 0.085;
        } else if (getDepartamento() == "Administración") {
            return getSalario_base() * 0.085;
        } else {
            return getSalario_base() * 0.04;
        }
    }

    public double getSubTras() {
        if(getSalario_base() <= 2000000){
            return 117172;
        }else{
            return 0;
        }
    }

    public double getAportes() {
        return getSalud() + getPension();
    }

    public int getvalorH() {
        return getSalario_base() / 240;
    }

}
