package com.example.buysell.controllers;

import com.example.buysell.models.Group;
import com.example.buysell.models.Product;
import com.example.buysell.models.Supplier;
import com.example.buysell.services.GroupService;
import com.example.buysell.services.ProductService;
import com.example.buysell.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class AdminProductController {

    private final ProductService productService;
    private final GroupService groupService;
    private final SupplierService supplierService;

    @GetMapping("/admin/product/insert")
    public String productAddProductForm(Model model)
    {
        model.addAttribute("groups", groupService.listGroup());
        model.addAttribute("suppliers", supplierService.listSupplier());
        return "productAdd";
    }

    @PostMapping("/admin/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3,
                                @RequestParam("groupId") Long groupId,
                                @RequestParam("supplierId") Long supplierId,
                                Product product
    ) throws IOException {
        Group group = groupService.findGroupById(groupId);
        product.setGroup(group);
        Supplier supplier = supplierService.findSupplierById(supplierId);
        product.setSupplier(supplier);
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/";
    }
}
