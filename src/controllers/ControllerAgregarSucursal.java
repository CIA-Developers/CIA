/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelAgregarSucursal;
import views.ViewAgregarSucursal;
/**
 *
 * @author Octaviano
 */
public class ControllerAgregarSucursal {
    ModelAgregarSucursal modelAgregarSucursal;
    ViewAgregarSucursal viewAgregarSucursal;

    public ControllerAgregarSucursal(ModelAgregarSucursal modelAgregarSucursal, ViewAgregarSucursal viewAgregarSucursal) {
        this.modelAgregarSucursal = modelAgregarSucursal;
        this.viewAgregarSucursal = viewAgregarSucursal;
    }

     
}
