package com.inventario.InventarioApp.servicies.provider;

import com.inventario.InventarioApp.entities.Provider;
import com.inventario.InventarioApp.repositories.logistics.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Provider getProvider(int id) {
        return null;
    }

    @Override
    public Provider addProvider(Provider provider) {
        return null;
    }

    @Override
    public Provider updateProvider(Provider provider) {
        return null;
    }

    @Override
    public void deleteProvider(int id) {

    }

    @Override
    public List<Provider> getAllProviders() {
        return List.of();
    }
}
