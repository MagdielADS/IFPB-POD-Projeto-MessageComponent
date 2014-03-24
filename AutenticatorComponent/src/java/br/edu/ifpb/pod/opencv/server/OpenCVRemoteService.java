/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.opencv.server;

import java.io.ByteArrayInputStream;
import java.rmi.Remote;

/**
 *
 * @author Magdiel Bruno
 */
public interface OpenCVRemoteService extends Remote {

    /**
     * Registra quatro imagens relacionadas a uma determinada pessoa.
     *
     * Retorna um token de identificação ou uma exceção, caso ocorra alguma
     * falha.
     *
     * @param images
     * @return
     * @throws OpenCVRemoteServiceException
     */
    String registry(ByteArrayInputStream... images) throws OpenCVRemoteServiceException;

    /**
     * Realiza o reconhecimento de uma determina pessoa a partir de uma
     * determinada imagem
     *     
*
     * @param image
     * @return
     * @throws OpenCVRemoteServiceException
     */
    String recognize(ByteArrayInputStream image) throws OpenCVRemoteServiceException;
}
