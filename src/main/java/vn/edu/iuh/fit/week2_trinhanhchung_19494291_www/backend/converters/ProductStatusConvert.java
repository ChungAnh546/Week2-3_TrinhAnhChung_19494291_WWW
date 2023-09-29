package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.backend.enums.ProductStatus;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProductStatusConvert implements AttributeConverter<ProductStatus,Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductStatus attribute) {
        if(attribute==null){
            return null;
        }
      return attribute.getValue();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer dbData) {
        if(dbData == null)
        {
            return null;
        }
        return Stream.of(ProductStatus.values())
                .filter(c->c.getValue() == dbData)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
