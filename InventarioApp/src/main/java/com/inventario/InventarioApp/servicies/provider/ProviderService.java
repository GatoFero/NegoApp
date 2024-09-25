package com.inventario.InventarioApp.servicies.provider;

import com.inventario.InventarioApp.entities.Provider;
import java.util.List;

public interface ProviderService {

    Provider getProvider(int id);
    Provider addProvider(Provider provider);
    Provider updateProvider(Provider provider);
    void deleteProvider(int id);
    List<Provider> getAllProviders();
}
