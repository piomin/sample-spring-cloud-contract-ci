import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		url '/persons/1'
	}
	response { 
		status OK()
		body([
			id: 1,
			firstName: 'Piotr',
			lastName: 'Minkowski',
			accountNo: $(regex(positiveInt())),
			birthDate: $(regex(isoDate()))
		])
		headers { 
			contentType(applicationJson())
		}
	}
}