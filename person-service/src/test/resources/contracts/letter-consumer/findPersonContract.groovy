import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		urlPath('/persons/1')
	}
	response { 
		status OK()
		body([
			id: 1,
			firstName: 'Piotr',
			lastName: 'Minkowski',
			address: ([ 
				city: $(regex(alphaNumeric())),
				country: $(regex(alphaNumeric())),
				postalCode: $(regex('[0-9]{2}-[0-9]{3}')),
				houseNo: $(regex(positiveInt())),
				street: $(regex(nonEmpty()))
			])
		])
		headers { 
			contentType(applicationJson())
		}
	}
}