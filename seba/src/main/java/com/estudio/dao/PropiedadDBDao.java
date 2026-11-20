package com.estudio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.estudio.database.ConectionDB;
import com.estudio.modelo.Casa;
import com.estudio.modelo.Departamento;
import com.estudio.modelo.Propiedad;

public class PropiedadDBDao implements PropiedadDao {

        @Override 
        public void guardar(Propiedad propiedad) {

        String sql = "INSERT INTO PROPIEDADES (tipo, direccion, arriendo_base, metros_cuadrados, cantidad_pisos, tiene_patio, numero_de_piso, gastos_comunes) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = ConectionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, propiedad.getTipo());
                ps.setString(2, propiedad.getDireccion());
                ps.setInt(3, propiedad.getArriendo());
                ps.setInt(4, propiedad.getMetrosCuadrados());

                if (propiedad instanceof Casa){
                    Casa casa = (Casa) propiedad;

                    ps.setNull(7, java.sql.Types.INTEGER);
                    ps.setNull(8, java.sql.Types.INTEGER);

                    ps.setString(1, "CASA");
                    ps.setInt(5, casa.getCantidadDePisos());
                    ps.setInt(6, casa.isTienePatio() ? 1 : 0 );
                }

                if (propiedad instanceof Departamento) {
                    Departamento depa = (Departamento) propiedad;

                    ps.setNull(5, java.sql.Types.INTEGER);
                    ps.setNull(6, java.sql.Types.INTEGER);

                    ps.setString(1, "DEPARTAMENTO");
                    ps.setInt(7, depa.getNumeroDePiso());
                    ps.setInt(8, depa.getGastosComunes());
                }

                ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al agregar la propiedad.");
        }

        }

        @Override
        public List<Propiedad> obtenerTodos() {

            List<Propiedad> lista = new ArrayList<>();
            String sql = "SELECT * FROM PROPIEDADES ORDER BY id ASC";

            try (Connection conn = ConectionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

                while (rs.next()){

                    int id = rs.getInt("id");
                    String tipo = rs.getString("tipo");
                    String direccion = rs.getString("direccion");
                    int arriendo = rs.getInt("arriendo_base");
                    int metros = rs.getInt("metros_cuadrados");

                    if ("CASA".equalsIgnoreCase(tipo)){

                        int pisos = rs.getInt("cantidad_pisos");
                        boolean patio = rs.getInt("tiene_patio") ==  1;
                        lista.add(new Casa(id, tipo, direccion, arriendo, metros, pisos, patio));

                    }

                    if ("DEPARTAMENTO".equalsIgnoreCase(tipo)) {

                        int numero = rs.getInt("numero_de_piso");
                        int gasto = rs.getInt("gastos_comunes");
                        lista.add(new Departamento(id, tipo, direccion, arriendo, metros, numero, gasto));
                    }
                    
                }
            } catch (Exception e) {
            System.out.println("Error al agregar la propiedad: " + e.getMessage());}
            return lista;
        }



        @Override
        public void actualizar(Propiedad propiedad) {
            String sql = "UPDATE PROPIEDADES SET tipo=?, direccion=?, arriendo_base=?, metros_cuadrados=?, cantidad_pisos=?, tiene_patio=?, numero_de_piso=?, gastos_comunes=? WHERE id=?";

            try (Connection conn = ConectionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql);){

                ps.setString(1, propiedad.getTipo());
                ps.setString(2, propiedad.getDireccion());
                ps.setInt(3, propiedad.getArriendo());
                ps.setInt(4, propiedad.getMetrosCuadrados());

                    if (propiedad instanceof Casa){
                    Casa casa = (Casa) propiedad;

                    ps.setInt(5, casa.getCantidadDePisos());
                    ps.setInt(6, casa.isTienePatio() ? 1 : 0 );

                    ps.setNull(7, java.sql.Types.INTEGER);
                    ps.setNull(8, java.sql.Types.INTEGER);                    
                    }

                    else if (propiedad instanceof Departamento){
                    Departamento depa = (Departamento) propiedad; 
                   
                    ps.setNull(5, java.sql.Types.INTEGER);
                    ps.setNull(6, java.sql.Types.INTEGER);
                    ps.setInt(7, depa.getNumeroDePiso());
                    ps.setInt(8, depa.getGastosComunes());
                    }

                    ps.setInt(9, propiedad.getId());
                    ps.executeUpdate();
            } catch (Exception e) {
            System.out.println("Error al actualizar la lista de propiedades: " + e.getMessage());
            }
        }

    @Override 
    public void eliminar(int id){
        String sql = "DELETE FROM PROPIEDADES WHERE id=?";
        try (Connection conn = ConectionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, id);
                ps.executeUpdate();
                
            } catch (Exception e) {
                System.out.println("Error al eliminar la propiedad: " + e.getMessage());
        }
    }
    
}
