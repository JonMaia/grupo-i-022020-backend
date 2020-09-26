package ar.edu.grupoi.backend.desappbackend;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class DesappBackendApplicationTests {

	@Autowired
    protected EntityManager em;
}
