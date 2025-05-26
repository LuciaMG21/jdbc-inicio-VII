package modelos;

import lombok.*;

// importa de lombok getter, setter y constructor.... simplifica
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Oficina {

    private String codigoOficina;
    private String ciudad;
    private String pais;
    private String region;
    private String codigoPostal;
    private String telefono;
    private String lineaDireccion1;
    private String lineaDireccion2;

    @Override
    public String toString() {
        return "Oficina{" +
                "codigoOficina='" + codigoOficina + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", region='" + region + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", telefono='" + telefono + '\'' +
                ", lineaDireccion1='" + lineaDireccion1 + '\'' +
                ", lineaDireccion2='" + lineaDireccion2 + '\'' +
                '}';
    }
}
